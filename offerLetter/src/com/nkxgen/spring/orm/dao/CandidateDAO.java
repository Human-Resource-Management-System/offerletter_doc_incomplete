package com.nkxgen.spring.orm.dao;

import java.util.List;

import com.nkxgen.spring.orm.model.Candidate;
import com.nkxgen.spring.orm.model.Employee;
import com.nkxgen.spring.orm.model.Eofr;

public interface CandidateDAO {
	List<Candidate> findAllIssuedCandidates();

	Candidate getCandidateById(int employeeId);

	void updateCandidateStatus(String string, String string2);

	Long getLatestEofrIdFromDatabase();

	void insertEofrInto(Eofr eofr);

	Employee getHrById(int hR_id);

}
