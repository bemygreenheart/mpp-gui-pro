//package uz.group.mppguiproject;
//
//import uz.group.mppguiproject.entity.Book;
//import uz.group.mppguiproject.entity.User;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.List;
//
//public class Main {
//
//	public static void main(String[] args) {
//		System.out.println(allWhoseZipContains3());
//		System.out.println(allHavingOverdueBook());
//		System.out.println(allHavingMultipleAuthors());
//
//	}
//	//Returns a list of all ids of LibraryMembers whose zipcode contains the digit 3
//	public static List<String> allWhoseZipContains3() {
//		DataAccess da = new DataAccessFacade();
//		Collection<User> members = da.readMemberMap().values();
//		List<User> mems = new ArrayList<>();
//		mems.addAll(members);
//		//implement
//		return null;
//
//	}
//	//Returns a list of all ids of  LibraryMembers that have an overdue book
//	public static List<String> allHavingOverdueBook() {
//		DataAccess da = new DataAccessFacade();
//		Collection<User> members = da.readMemberMap().values();
//		List<User> mems = new ArrayList<>();
//		mems.addAll(members);
//		//implement
//		return null;
//
//	}
//
//	//Returns a list of all isbns of  Books that have multiple authors
//	public static List<String> allHavingMultipleAuthors() {
//		DataAccess da = new DataAccessFacade();
//		Collection<Book> books = da.readBooksMap().values();
//		List<Book> bs = new ArrayList<>();
//		bs.addAll(books);
//		//implement
//		return null;
//
//		}
//
//}