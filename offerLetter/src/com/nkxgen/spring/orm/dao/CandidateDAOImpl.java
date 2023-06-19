package com.nkxgen.spring.orm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nkxgen.spring.orm.model.Candidate;
import com.nkxgen.spring.orm.model.Employee;
import com.nkxgen.spring.orm.model.Eofr;

@Repository
public class CandidateDAOImpl implements CandidateDAO {

	@PersistenceContext
	private EntityManager entityManager;
	Candidate can;
	Employee emp;

	@Override
	@Transactional
	public List<Candidate> findAllIssuedCandidates() {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<Candidate> cq = cb.createQuery(Candidate.class);
		Root<Candidate> root = cq.from(Candidate.class);
		cq.select(root);
		cq.where(cb.equal(root.get("cand_status"), "NA"));
		TypedQuery<Candidate> query = entityManager.createQuery(cq);
		return query.getResultList();
	}

	public Candidate getCandidateById(int candidateId) {
		can = entityManager.find(Candidate.class, candidateId);
		return can;
	}

	@Override
	@Transactional
	public void updateCandidateStatus(String cand_status, String newValue) {
		can.setCand_status(newValue); // Modify the desired column value
		entityManager.merge(can); // Save the changes to the database
	}

	@Override
	@Transactional
	public void insertEofrInto(Eofr eofr) {
		entityManager.persist(eofr); // Persist the new entity

	}

	@Override
	@Transactional
	public Long getLatestEofrIdFromDatabase() {
		// Create a query to retrieve the latest eofr_id
		Query query = entityManager.createQuery("SELECT MAX(e.eofr_id) FROM Eofr e");

		// Execute the query and retrieve the result
		Long latestEofrId = (Long) query.getSingleResult();

		// If the result is null (no records in the table), set the latestEofrId to 0
		if (latestEofrId == null) {
			latestEofrId = 0L;
		}
		System.out.println(latestEofrId);
		return latestEofrId;

	}

	@Override
	public Employee getHrById(int hR_id) {

		emp = entityManager.find(Employee.class, hR_id);

		return emp;
	}

}