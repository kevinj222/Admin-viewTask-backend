package com.Daily.Userview.Service;

import com.Daily.Userview.Entity.View;
import com.Daily.Userview.Repo.ViewRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ViewService
{
    @Autowired
    public ViewRepo repo;
    List<View>max=null;

    public View Addusers(View view)
    {
        return repo.save(view);
    }

    public List<View> getallusers()
    {
        return repo.findAll();
    }

    public List<View> getbyusername(String username)
    {
        List<View>max=repo.findByUsername(username);
        return max;
    }

    public String deleteTask(String username, String tasks)
    {
        int vid=0;
        List<View> views = repo.findByUsername(username);
        if (!views.isEmpty())
        {
           // List<View>max=views;
            for (View view : views)
            {
                if (view.getTasks().contains(tasks))
                {
                    vid = view.getId();
                    break;
                }
            }
        }
        else
        {
            return "Value not found";
        }
        repo.deleteById(vid);
        return "String deleted";
    }

    public Set<String> getDistinctUsernames()
    {
        List<View> views = repo.findAll();
        return views.stream()
                .map(View::getUsername)
                .collect(Collectors.toSet());
    }

    public View modify(String username, String tasks, String newDeadline)
    {

        int vid = 0;
        View max=null;
        List<View> views = repo.findByUsername(username);
        if (!views.isEmpty())
        {
            // List<View>max=views;
            for (View view : views)
            {
                if (view.getTasks().contains(tasks))
                {
                    vid = view.getId();
                    break;
                }
            }
            Optional<View> optionalView = repo.findById(vid);
            if (optionalView.isPresent()) {
                View view = optionalView.get();
                view.setDeadline(newDeadline);
                max=repo.save(view);
            }
            else
            {
                // Handle the case where the View entity with the given ID is not found
                throw new IllegalArgumentException("View not found with ID: " + vid);
            }
        }
        return max;
    }
}
