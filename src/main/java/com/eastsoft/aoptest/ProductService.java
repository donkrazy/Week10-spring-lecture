package com.eastsoft.aoptest;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	public ProductVo findProduct( String name ){
		System.out.println( "finding product[" + name + "]....." );
		
		if( 1 == 1 ) {
			throw new RuntimeException( "ProductService Exception" );
		}
		
		return new ProductVo( name );
	}
}
