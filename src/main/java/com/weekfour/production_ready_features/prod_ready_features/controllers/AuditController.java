package com.weekfour.production_ready_features.prod_ready_features.controllers;

import com.weekfour.production_ready_features.prod_ready_features.entities.PostEntity;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/audit")
public class AuditController {

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    //to use by the admins to get the history of edit of posts we have directly use entity here without
    // using of the DTO as admin can see all the data
    //localhost:8080/audit/posts/5
    @GetMapping(path="/posts/{postId}")
    List<PostEntity> getPostRevisions(@PathVariable Long postId){
        AuditReader reader= AuditReaderFactory.get(entityManagerFactory.createEntityManager());
        List<Number> revisions=reader.getRevisions(PostEntity.class,postId);
        return revisions
                .stream()
                .map(revisionNumber -> reader.find(PostEntity.class, postId, revisionNumber))
                .collect(Collectors.toList());
    }

    //output
//    [
//    {
//        "id": 5,
//            "title": "This is the title 7",
//            "description": "This is description 7",
//            "createdBy": "supreet kumar",
//            "createdDate": "2025-12-02T23:37:36.363863",
//            "updatedBy": "supreet kumar",
//            "updatedDate": "2025-12-02T23:37:36.363863"
//    },
//    {
//        "id": 5,
//            "title": "This is the title 8",
//            "description": "This is description 7",
//            "createdBy": "supreet kumar",
//            "createdDate": "2025-12-02T23:37:36.363863",
//            "updatedBy": "supreet kumar",
//            "updatedDate": "2025-12-02T23:39:59.86444"
//    },
//    {
//        "id": 5,
//            "title": "This is the title 5",
//            "description": "This is description 75",
//            "createdBy": "supreet kumar",
//            "createdDate": "2025-12-02T23:37:36.363863",
//            "updatedBy": "supreet kumar",
//            "updatedDate": "2025-12-03T00:19:26.883746"
//    },
//    {
//        "id": 5,
//            "title": "This is the title 55",
//            "description": "This is description 755",
//            "createdBy": "supreet kumar",
//            "createdDate": "2025-12-02T23:37:36.363863",
//            "updatedBy": "supreet kumar",
//            "updatedDate": "2025-12-03T00:19:32.951332"
//    },
//    {
//        "id": 5,
//            "title": "This is the title 556",
//            "description": "This is description 755",
//            "createdBy": "supreet kumar",
//            "createdDate": "2025-12-02T23:37:36.363863",
//            "updatedBy": "supreet kumar",
//            "updatedDate": "2025-12-03T00:19:37.370496"
//    },
//    {
//        "id": 5,
//            "title": "This is the title 5",
//            "description": "This is description 5",
//            "createdBy": "supreet kumar",
//            "createdDate": "2025-12-02T23:37:36.363863",
//            "updatedBy": "supreet kumar",
//            "updatedDate": "2025-12-03T00:19:45.388377"
//    }
//]


}
