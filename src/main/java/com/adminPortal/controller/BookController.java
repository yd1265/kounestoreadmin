package com.adminPortal.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.adminPortal.domain.Book;
import com.adminPortal.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String addBook( Model model){
		Book book=new Book();
		model.addAttribute("book", book);
		return "addBook";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addBookPost(
			@ModelAttribute ("book") Book book){
		bookService.save(book);
		MultipartFile bookImage=book.getBookImage();
			try {
				byte [] bytes=bookImage.getBytes();

				String name=book.getId()+".png";
				BufferedOutputStream stream=new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/images/book/"+name)));
					stream.write(bytes);
					stream.close();
		
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		return "redirect:bookList";
		
	}
	
	@RequestMapping(value="/bookList",method=RequestMethod.GET)
	public String bookList(Model model){
		List<Book> bookList=bookService.findAll();
		model.addAttribute("bookList",bookList);
		
		return "bookList";
	}
	
	
	@RequestMapping("/bookInfo")
	public String bookInfo(@RequestParam("id") Long id, Model model ){
		Book book =bookService.findOne(id);
		model.addAttribute("book",book);
		
		return "bookInfo";
	}
	
	
	@RequestMapping(value="/deleteBook",method=RequestMethod.POST)
	
	public String deleteBookPost(@RequestParam("id") Long id, Model model, HttpServletRequest request){
		    Book book =bookService.findOne(id);
		    
		      String name=book.getId() +".png";
			   bookService.deleteBook(id);

		     try {
				Files.delete(Paths.get("src/main/resources/static/images/book/"+name));
			} catch (IOException e) {
				e.printStackTrace();
			}		     
		     
	
		return "bookList";
	}
	
	
	/*
	 *  for just the get part showing the form 
	 */
	@RequestMapping(value="/deleteBook",method=RequestMethod.GET)
	public String deleteBook(@RequestParam("id") Long id, Model model){
		 Book book=bookService.findOne(id);
		 model.addAttribute("book", book);
		return "deleteBook";
	}
	
	
	
	/*
	 *  for just the get part showing the form 
	 */
	@RequestMapping(value="/bookupdate",method=RequestMethod.GET)
	public String updateBook(@RequestParam("id") Long id, Model model){
		Book book=bookService.findOne(id);
		model.addAttribute("book",book);
		return "bookUpdate";
	}
	
	
	@RequestMapping(value="/bookupdate",method=RequestMethod.POST)

	public String postBook(@ModelAttribute("book") Book book, Model model,HttpServletRequest request){
		 bookService.save(book);
		 MultipartFile bookImage=book.getBookImage();
		 
                 if(!bookImage.isEmpty()){
                	 try {
						byte [] bytes=bookImage.getBytes();
						String name=book.getId()+".png";
										
						BufferedOutputStream stream=new BufferedOutputStream(new FileOutputStream(new File("src/main/resources/static/images/book/"+name)));
						    stream.write(bytes);
						    stream.close();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
                 }
		return "redirect:bookInfo?id="+book.getId();
		
	}

	
	

}

