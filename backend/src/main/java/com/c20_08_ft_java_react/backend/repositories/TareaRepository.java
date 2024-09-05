package com.c20_08_ft_java_react.backend.repositories;

import com.c20_08_ft_java_react.backend.models.TareaEntify;
import com.c20_08_ft_java_react.backend.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Optional;

@Repository
public interface TareaRepository extends JpaRepository<TareaEntify, String> {

    Optional<TareaEntify> findByUsername(String username);

    Optional<TareaEntify>(Date fechaexp);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);


    @Query("delete from tareas where etiquetaId = ?1")
    public void deleteByTarea(Integer etiquetaId);

    @Query("select u from UserEntity u where u.userName = ?1")
    public UserEntity findByEtiquetaName(String userName);


}
