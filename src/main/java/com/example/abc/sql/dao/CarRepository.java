package com.example.abc.sql.dao;
/*
- copyright http:\\test
- author lee
- date 2024-03-25
- version v1.0
*/

import com.example.abc.sql.BasicRepository;
import com.example.abc.sql.entity.Car;
import com.example.abc.sql.entity.Customer;
import com.example.abc.sql.entity.SignOrder;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CarRepository extends BasicRepository<Car, Integer> {

    @Query(" select new map(name as name ,type as type)from Car where name=?1 and type=?2 ")
    public List getAllCarData2( String name , String type);

    @Modifying
    @Query(" delete from Car where id=:c1 and name=:c2" )
    void deleteOne(@Param("c1") int id , @Param("c2") String name);

    @Modifying
    @Query( value=
            " delete a from Car a "+
            " inner join Customer b on b.id = a.customerId  " +
            " inner join signorder c on c.id = a.signorderId " +
            " where b.id=:c1 and c.id=:c2 " , nativeQuery = true)
    void deleteMany(@Param("c1") Customer customer , @Param("c2") SignOrder signOrder);
}














