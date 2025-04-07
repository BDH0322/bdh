package com.mbc.bdh6.book;

import java.util.ArrayList;

public interface BookService {

	void inserta(String bname, String bwriter, String bmemo, int bprice, String fname, String bdate);

	ArrayList<BookDTO> select();

	BookDTO delete(int num);

}
