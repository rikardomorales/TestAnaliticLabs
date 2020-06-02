/**
*
* Classname: TestController
* @version 1.0 31/05/2020 
* @author Ricardo Alejandro Morales Penilla
* 
*/
package com.analiticlabs.test.controller;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/test" })
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.POST,RequestMethod.DELETE })
public class TestController
{
	/**
	 * this service return 
	 * number of repeat caracters
	 * @return response
	 */
	@GetMapping("/getCountCaracter") 
	public String getCountCaracter(@RequestParam("str") String str)
	{
	  String response = "Error";
	  try
	  {
		response = this.contarCaracteres(str);
	  }catch(Exception e)
	   {
		 System.out.println("Error: "+e.getMessage());
	   }
	  return response;
	}
	
	/**
	 * this method count caracters of
	 * a String
	 * @param str
	 * @return resultado
	 */
	public String contarCaracteres(String str) 
	{
		String resultado = "";
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		for(char caracter : str.toCharArray()){
		    if(map.containsKey(caracter)) {
		        map.put(caracter, map.get(caracter) + 1);
		    } else {
		        map.put(caracter, 1);
		    }
		}
		resultado = map.toString();
        return resultado;
    }
	
	/**
	 * this service return 
	 * an example of Stream
	 * Java 8
	 * @return response
	 */
	@GetMapping("/getStream") 
	public String getStream()
	{
	  String response = "Error";
	  try
	  {
		response = this.testStream();
	  }catch(Exception e)
	   {
		 System.out.println("Error: "+e.getMessage());
	   }
	  return response;
	}
	
	/**
	 * prints by console the numbers greater than or equal to 1 found
	 * @param str
	 * @return response
	 */
	public String testStream()
	{
	 String response = "OK"; 
	   try
	   {	
		   Pattern patron=Pattern.compile("\\d+");
		   Stream<String> mistream=Stream.of("cuales numeros","1","2","3","4","hay","5");
		   
		    mistream.filter(patron.asPredicate())
					    .map(Integer::parseInt)
					    .filter(n->n>=1)
					    .forEach(System.out::println);
	   }catch(Exception e)
	    {
	 	  System.out.println("Error: "+e.getMessage());
	    }
	    return response;
	}	
}
