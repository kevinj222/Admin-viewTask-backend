package com.Daily.Userview.Repo;

import com.Daily.Userview.Entity.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ViewRepo extends JpaRepository<View,Integer >
{
    List<View> findByUsername(String username);
    List<View> findByTasks(String tasks);

   // View findByUsernameAndTask(String username, String task);
}
