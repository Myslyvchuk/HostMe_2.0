package com.softserve.edu.dao.impl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.softserve.edu.dao.RequestDao;
import com.softserve.edu.entity.Request;
import com.softserve.edu.entity.exceptions.RequestAlreadySentException;

@Repository
public class RequestDaoImpl extends AbstractGenericDao<Request, Long> implements
		RequestDao {
	public RequestDaoImpl() {
		super(Request.class);
	}

	private String FROM_REQUEST = "From Request   WHERE ";

	@Override
	public boolean checkRequest(Request request)
			throws RequestAlreadySentException {
		StringBuilder builder = new StringBuilder();
		builder.append(FROM_REQUEST);
		Timestamp timestamp = new Timestamp(request.getEndDate().getTimeInMillis());
		builder.append("end_date='").append(timestamp);
		builder.append("' AND ");
		builder.append("begin_date='").append(new Timestamp(request.getBeginDate().getTimeInMillis()));
		builder.append("' AND ");
		builder.append("hosting_id='").append(
				request.getHosting().getHostingId());
		builder.append("' AND ");
		builder.append("user_id='");
		builder.append(request.getAuthor().getUserId());
		builder.append("'");
		Query query = getSessionFactory().getCurrentSession().createQuery(
				builder.toString());
		ArrayList<Request> existingRequests = (ArrayList<Request>) query.list();
		//
		// Criteria criteria = getSessionFactory().getCurrentSession()
		// .createCriteria(Request.class);
		// criteria.setFetchMode("request.hosting", FetchMode.JOIN);
		// criteria.add(Restrictions.eq("endDate", request.getEndDate()));
		// criteria.add(Restrictions.eq("beginDate", request.getBeginDate()));
		// criteria.add(Restrictions.eq("hosting_id", request.getHosting()));
		// ArrayList<Request> existingRequests = (ArrayList<Request>)
		// criteria.list();
		if (!existingRequests.isEmpty()) {
			throw new RequestAlreadySentException();
		}
		return true;
	}
}