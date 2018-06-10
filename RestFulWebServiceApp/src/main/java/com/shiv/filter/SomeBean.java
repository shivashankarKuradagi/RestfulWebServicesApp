package com.shiv.filter;

import com.fasterxml.jackson.annotation.JsonFilter;

@JsonFilter( "someBeanFilter" )
public class SomeBean
{
    String one;
    String two;
    String three;

    public String getOne()
    {
        return one;
    }

    public void setOne( String one )
    {
        this.one = one;
    }

    public String getTwo()
    {
        return two;
    }

    public void setTwo( String two )
    {
        this.two = two;
    }

    public String getThree()
    {
        return three;
    }

    public void setThree( String three )
    {
        this.three = three;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( one == null ) ? 0
            : one.hashCode() );
        result = prime * result + ( ( three == null ) ? 0
            : three.hashCode() );
        result = prime * result + ( ( two == null ) ? 0
            : two.hashCode() );
        return result;
    }

    @Override
    public boolean equals( Object obj )
    {
        if( this == obj )
            return true;
        if( obj == null )
            return false;
        if( getClass() != obj.getClass() )
            return false;
        SomeBean other = (SomeBean) obj;
        if( one == null )
        {
            if( other.one != null )
                return false;
        }
        else if( !one.equals( other.one ) )
            return false;
        if( three == null )
        {
            if( other.three != null )
                return false;
        }
        else if( !three.equals( other.three ) )
            return false;
        if( two == null )
        {
            if( other.two != null )
                return false;
        }
        else if( !two.equals( other.two ) )
            return false;
        return true;
    }

    public SomeBean()
    {
        super();
        // TODO Auto-generated constructor stub
    }

    public SomeBean( String one,
        String two,
        String three )
    {
        super();
        this.one = one;
        this.two = two;
        this.three = three;
    }
}
