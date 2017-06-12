package domain;

import java.util.List;

public class HasReachMaxSpecification implements IsSpecification<Member> {
	
	public boolean isSatisfiedBy(Member member) {
		boolean i = false;
		List<Loan> list = member.getLoans();
		if(list == null || list.size()<3){
			i=true;
		}
		return i;
		
	}
}
