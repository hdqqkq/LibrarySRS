package test;

import org.junit.Test;

import domain.Book;
import domain.Member;

public class libraryTest {
	
	private Book book1,book2,book3,book4;
	private Member member1;	
	//添加用户
	public void addMember(){
		member1 = new Member();
		member1.setId("0001");
		member1.setName("小红");
	}
	//添加图书
	public void addBook(){
		book1 = new Book();
		book2 = new Book();
		book3 = new Book();
		book4 = new Book();
		book1.setId("0001");
		book1.setiSBN("Cumt001");
		book1.settItle("穆斯林的葬礼");
		book1.setLoanTo(null);
		book2.setId("0002");
		book2.setiSBN("Cumt002");
		book2.settItle("白鹿原");
		book2.setLoanTo(null);
		book3.setId("0003");
		book3.setiSBN("Cumt003");
		book3.settItle("活着");
		book3.setLoanTo(null);
		book4.setId("0004");
		book4.setiSBN("Cumt004");
		book4.settItle("许三多卖血记");
		book4.setLoanTo(null);
	}
	//借书成功
	@Test
	public void loanSuccess(){
		this.addMember(); 
		this.addBook();
		member1.Loan(book1);
		member1.Loan(book2);
		member1.Loan(book3);
		System.out.println("***********借书记录***************");
		System.out.println("姓名：" + member1.getName());
		System.out.println("书名：" + book1.gettItle() + "、" + book2.gettItle() + "、" + book3.gettItle());
		System.out.println("借书时间：" + member1.getLoans().get(0).getLoanDate());
		
	}
	//借书失败
	@Test
	public void loanFail(){
		this.loanSuccess();
		member1.Loan(book1);
		if(member1.validate(book1)==false){
			System.out.println("借书失败");
		}
	}
	//还书
	@Test
	public void returnBook(){
		this.loanSuccess();
		member1.Return(book1);
		System.out.println("***********还书记录***************");
		System.out.println("姓名：" + member1.getName());
		System.out.println("书名：" + book1.gettItle());
	}
}
