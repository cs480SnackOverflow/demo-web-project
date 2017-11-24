package edu.csupomona.cs480.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.math.complex.Complex;
import org.apache.commons.math.random.JDKRandomGenerator;
import org.apache.commons.math.random.UniformRandomGenerator;
import org.joda.time.DateTime;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import edu.csupomona.cs480.App;
import edu.csupomona.cs480.data.entity.User;


/**
 * This is the controller used by Spring framework.
 * <p>
 * The basic function of this controller is to map
 * each HTTP API Path to the correspondent method.
 */

@RestController
public class WebController {

	/**
	 * This is a simple example of how the HTTP API works.
	 * It returns a String "OK" in the HTTP response.
	 * To try it, run the web application locally,
	 * in your web browser, type the link:
	 * 	http://localhost:8080/cs480/ping
	 */
	@RequestMapping(value = "/cs480/ping", method = RequestMethod.GET)
	String healthCheck() {
		// You can replace this with other string,
		// and run the application locally to check your changes
		// with the URL: http://localhost:8080/
		return "OK";
	}

	@RequestMapping(value = "/cs480/greetings", method = RequestMethod.GET)
	String greeting() {
		// You can replace this with other string,
		// and run the application locally to check your changes
		// with the URL: http://localhost:8080/
		return "Hello User. How are you?";
	}

	/**
	 * Usage of Java Joda-Time library to display a Joda-Time DateTime object from a
     * less detailed java.util.Date object
	 * @return Joda-Time date containing day, month, year, hour, sec, etc...
	 */
	@RequestMapping(value = "/date", method = RequestMethod.GET)
	DateTime currentDateTime() {
    	return new DateTime(new Date());
	}
	
	/**
	 * Usage of Java Jsoup to parse all stories from hacker news, a news website
	 */
	@RequestMapping(value = "/hackernews", method = RequestMethod.GET) 
	String latestNews() throws IOException {
		org.jsoup.nodes.Document doc = Jsoup.connect("https://news.ycombinator.com/").get();
		Elements newsHeadline = doc.select("a.storylink");
		return newsHeadline.toString();
	}

	/**
	 * Usage of Java Apache Math Commons to do some simple complex arithmetic
	 */
	@RequestMapping(value = "/complexmath", method = RequestMethod.GET)
	String randomComplexSum() {
		UniformRandomGenerator random = new UniformRandomGenerator(new JDKRandomGenerator());
		Complex complex1 = new Complex(random.nextNormalizedDouble(), random.nextNormalizedDouble());
		Complex complex2 = new Complex(random.nextNormalizedDouble(), random.nextNormalizedDouble());
		Complex complexSum = complex1.add(complex2);
		return "[ " + complex1.getReal() + ", " +  + complex1.getImaginary() + " ] + [ " + complex2.getReal() + ", " +  + complex2.getImaginary() + " ] = [ " + complexSum.getReal() + ", " +  + complexSum.getImaginary() + " ]" ;
	}


	//Actual project code starts here

	/**
	 * @return a simple html page through which one can test polly
	 */
	@RequestMapping(value="/testaudio")
	ModelAndView audioTest() {
		return new ModelAndView("audiotest");
	}
}