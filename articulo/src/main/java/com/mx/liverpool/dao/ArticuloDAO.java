package com.mx.liverpool.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mx.liverpool.entity.Articulo;

public interface ArticuloDAO  extends JpaRepository<Articulo, Long>{

}
