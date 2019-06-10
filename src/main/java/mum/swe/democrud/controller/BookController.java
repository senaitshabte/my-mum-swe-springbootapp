package mum.swe.democrud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mum.swe.democrud.model.Book;
import mum.swe.democrud.service.BookService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping(value="/books", method = RequestMethod.GET)
	public ModelAndView books(){		
		List<Book> books = bookService.findAll();		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("books", books);
		modelAndView.setViewName("book/list");
		return modelAndView;
	}
	
	@RequestMapping(value="/book", method = RequestMethod.GET)
	public String create(Model model){			
		model.addAttribute("book", new Book());
		return "book/edit";
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public String edit(@Valid @ModelAttribute("book") Book book, 
			BindingResult result, Model model)  {

		if (result.hasErrors()) {
			model.addAttribute("errors", result.getAllErrors());
			return "book/edit";
		}
		book = bookService.save(book);
		return "redirect:/books";
	}	
	
	@RequestMapping(value="/book/{id}", method = RequestMethod.GET)
	public String view(@PathVariable Long id, Model model){	
		model.addAttribute("book", bookService.findOne(id));
		return "book/edit";
	}
	
	@RequestMapping(value="/book/delete/{id}", method = RequestMethod.GET)
	public String delete(@PathVariable Long id, Model model){		
		bookService.delete(id);
		return "redirect:/books";
	}	
}
