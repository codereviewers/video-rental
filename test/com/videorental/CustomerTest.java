package com.videorental;


import static org.junit.Assert.*;

import org.junit.Test;

public class CustomerTest {


	@Test
	public void should_be_not_null_when_new_object(){
		Movie movie = new Movie("제목1",1);
		Rental rental = new Rental(movie,30);
		Customer customer = new Customer("홍길동");
		assertNotNull("movie 생성",movie);
		assertNotNull("rental 생성",rental);
		assertNotNull("customer 생성",customer);
	}

	@Test
	public void should_return_30_when_do_getDaysRented_30(){
		Movie movie = new Movie("제목1",1);
		Rental rental = new Rental(movie,30);

		assertEquals(30,rental.getDaysRented());
	}

	@Test
	public void should_return_movie_when_do_getMovie(){
		Movie movie = new Movie("제목1",1);
		Rental rental = new Rental(movie,30);

		assertEquals(movie,rental.getMovie());
	}

	@Test
	public void should_return_priceCode_when_do_getPriceCode(){
		Movie movie = new Movie("제목1",1);
		assertEquals(1,movie.getPriceCode());

		movie = new Movie("제목2",2);
		assertEquals(2,movie.getPriceCode());
	}

	@Test
	public void should_return_title_when_do_getTitle(){
		Movie movie = new Movie("제목1",1);
		assertEquals("제목1",movie.getTitle());

		movie = new Movie("제목2",2);
		assertEquals("제목2",movie.getTitle());
	}

	@Test
	public void should_return_updatedPriceCode_when_do_setPriceCode(){
		Movie movie = new Movie("제목1",1);
		movie.setPriceCode(2);
		assertEquals(2,movie.getPriceCode());

		movie.setPriceCode(3);
		assertEquals(3,movie.getPriceCode());
	}

	@Test
	public void should_return_added_statement_when_do_addRental(){
		Movie movie = new Movie("제목1",1);
		Rental rental = new Rental(movie,30);
		Customer customer = new Customer("홍길동");

		customer.addRental(rental);
		assertEquals("Rental Record for 홍길동\n" +
				"\t90.0(제목1)\n" +
				"Amount owed is 90.0\n" +
				"You earned 2 frequent renter pointers",customer.statement());
	}

	@Test
	public void should_return_name_when_do_getName(){
		Movie movie = new Movie("제목1",1);
		Rental rental = new Rental(movie,30);
		Customer customer = new Customer("홍길동");

		assertEquals("홍길동",customer.getName());
	}

	@Test
	public void should_return_regular_when_do_statement(){
		Movie movie = new Movie("제목1",0);
		Rental rental = new Rental(movie,30);
		Customer customer = new Customer("홍길동");

		customer.addRental(rental);
		assertEquals("Rental Record for 홍길동\n" +
				"\t44.0(제목1)\n" +
				"Amount owed is 44.0\n" +
				"You earned 1 frequent renter pointers",customer.statement());

		movie = new Movie("제목2",0);
		rental = new Rental(movie,1);
		customer.addRental(rental);
		assertEquals("Rental Record for 홍길동\n" +
				"\t44.0(제목1)\n" +
				"\t2.0(제목2)\n" +
				"Amount owed is 46.0\n" +
				"You earned 2 frequent renter pointers",customer.statement());
	}

	@Test
	public void should_return_regular_low_when_do_statement(){
		Movie movie = new Movie("제목1",0);
		Rental rental = new Rental(movie,1);
		Customer customer = new Customer("홍길동");

		customer.addRental(rental);
		assertEquals("Rental Record for 홍길동\n" +
				"\t2.0(제목1)\n" +
				"Amount owed is 2.0\n" +
				"You earned 1 frequent renter pointers",customer.statement());
	}

	@Test
	public void should_return_new_release_when_do_statement(){
		Movie movie = new Movie("제목1",1);
		Rental rental = new Rental(movie,30);
		Customer customer = new Customer("홍길동");

		customer.addRental(rental);
		assertEquals("Rental Record for 홍길동\n" +
				"\t90.0(제목1)\n" +
				"Amount owed is 90.0\n" +
				"You earned 2 frequent renter pointers",customer.statement());
	}

	@Test
	public void should_return_new_release_low_when_do_statement(){
		Movie movie = new Movie("제목1",1);
		Rental rental = new Rental(movie,0);
		Customer customer = new Customer("홍길동");

		customer.addRental(rental);
		assertEquals("Rental Record for 홍길동\n" +
				"\t0.0(제목1)\n" +
				"Amount owed is 0.0\n" +
				"You earned 1 frequent renter pointers",customer.statement());
	}

	@Test
	public void should_return_childrens_when_do_statement(){
		Movie movie = new Movie("제목1",2);
		Rental rental = new Rental(movie,30);
		Customer customer = new Customer("홍길동");

		customer.addRental(rental);
		assertEquals("Rental Record for 홍길동\n" +
				"\t42.0(제목1)\n" +
				"Amount owed is 42.0\n" +
				"You earned 1 frequent renter pointers",customer.statement());
	}

	@Test
	public void should_return_childrens_low_when_do_statement(){
		Movie movie = new Movie("제목1",2);
		Rental rental = new Rental(movie,1);
		Customer customer = new Customer("홍길동");

		customer.addRental(rental);
		assertEquals("Rental Record for 홍길동\n" +
				"\t1.5(제목1)\n" +
				"Amount owed is 1.5\n" +
				"You earned 1 frequent renter pointers",customer.statement());
	}


	@Test
	public void should_return_normal_when_do_statement(){
		Movie movie = new Movie("제목1",-1);
		Rental rental = new Rental(movie,30);
		Customer customer = new Customer("홍길동");

		customer.addRental(rental);
		assertEquals("Rental Record for 홍길동\n" +
				"\t0.0(제목1)\n" +
				"Amount owed is 0.0\n" +
				"You earned 1 frequent renter pointers",customer.statement());
	}
}