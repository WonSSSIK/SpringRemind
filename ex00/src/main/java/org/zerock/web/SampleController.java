package org.zerock.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.ProductVO;

@Controller
public class SampleController {
	private static final Logger logger = 
			LoggerFactory.getLogger(SampleController.class);
	
	@RequestMapping("doA")
	public void doA() {
		logger.info("doA called..........................");
	}
	@RequestMapping("doB")
	public void doB()
	{
		logger.info("doB called....................");
	}
	@RequestMapping("doC")
	public String doC(@ModelAttribute("msg") String msg) {
		logger.info("doC..................................");
		
		return "result";
	}
	@RequestMapping("doD")
	public String doD(Model model) {
		//Make sample data
		ProductVO product = new ProductVO("Sample Product", 100000); 
		
		logger.info("doD");
		
		model.addAttribute(product);
		return "productDetail";
	}
	
	@RequestMapping("/doE")
	public String doE(RedirectAttributes rttr) {
		logger.info("doE called but redirect to /doF....................");
		
		rttr.addFlashAttribute("msg","This is the Message!! with redirected");
		return "redirect:/doF";
	}
	
	@RequestMapping("/doF")
	public void doF(@ModelAttribute("msg") String msg) {
		System.out.println(msg);
		logger.info("doF called ..............................."+msg);
	}
	
	@RequestMapping("/doJSON")
	public @ResponseBody ProductVO doJSON() {
		ProductVO vo = new ProductVO("»ùÇÃ»óÇ°",300000);
		
		return vo;
	}

}
