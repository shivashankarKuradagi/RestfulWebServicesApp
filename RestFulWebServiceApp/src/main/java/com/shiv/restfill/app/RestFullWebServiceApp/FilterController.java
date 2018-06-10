package com.shiv.restfill.app.RestFullWebServiceApp;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.shiv.filter.SomeBean;

@RestController
public class FilterController
{

    @GetMapping( value = "/filter" )
    public MappingJacksonValue getValue()
    {
        SomeBean bean = new SomeBean( "one", " two", "three" );

        SimpleBeanPropertyFilter simpleBeanPropertyFilter = SimpleBeanPropertyFilter.filterOutAllExcept( "one" );
        FilterProvider filter = new SimpleFilterProvider().addFilter( "someBeanFilter", simpleBeanPropertyFilter );
        MappingJacksonValue mapping = new MappingJacksonValue( bean );
        mapping.setFilters( filter );

        return mapping;
    }

    @RequestMapping( value = "/filters", method = RequestMethod.GET )
    public List<SomeBean> getValues()
    {
        SomeBean bean = new SomeBean( "one", " two", "three" );
        return Arrays.asList( new SomeBean( "1", "2", "3" ), new SomeBean( "11", "22", "33" ) );
    }

}
