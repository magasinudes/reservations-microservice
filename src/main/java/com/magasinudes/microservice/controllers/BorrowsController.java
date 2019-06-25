package com.magasinudes.microservice.controllers;

import com.magasinudes.microservice.exceptions.RecordNotFoundException;
import com.magasinudes.microservice.models.Borrow;
import com.magasinudes.microservice.repositories.BorrowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

public class BorrowsController {
}
