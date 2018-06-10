package com.shiv.restfill.app.RestFullWebServiceApp;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
public class User
{
    @Id
    @GeneratedValue
    @Column( name = "ID" )
    private int id;

    @Column( name = "NAME" )
   // @Min( value = 2, message = "Mininum 2 leters has to be there" )
    private String name;

    @Column( name = "BIRTH_DATE" )
    private Date birthDate;

    public User()
    {
    }

    public User( int id,
        String name,
        Date birthDate )
    {
        super();
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public int getId()
    {
        return id;
    }

    public void setId( int id )
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    public Date getBirthDate()
    {
        return birthDate;
    }

    public void setBirthDate( Date birthDate )
    {
        this.birthDate = birthDate;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ( ( birthDate == null ) ? 0
                : birthDate.hashCode() );
        result = prime * result + id;
        result = prime * result
            + ( ( name == null ) ? 0
                : name.hashCode() );
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
        User other = (User) obj;
        if( birthDate == null )
        {
            if( other.birthDate != null )
                return false;
        }
        else if( !birthDate.equals( other.birthDate ) )
            return false;
        if( id != other.id )
            return false;
        if( name == null )
        {
            if( other.name != null )
                return false;
        }
        else if( !name.equals( other.name ) )
            return false;
        return true;
    }

}
