package dev.ajay.library.controller;

import dev.ajay.library.model.BorrowingRecord;
import dev.ajay.library.service.serviceimpl.BorrowingRecordServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/borrowing-records")
public class BorrowingRecordController {
    @Autowired
    private BorrowingRecordServiceImpl borrowingRecordService;

    @GetMapping("/user/{username}")
    public ResponseEntity<List<BorrowingRecord>> getBorrowingRecordsByUsername(@PathVariable String username) {
        List<BorrowingRecord> borrowingRecords = borrowingRecordService.getBorrowingRecordsByUsername(username);
        return new ResponseEntity<>(borrowingRecords, HttpStatus.OK);
    }

    @GetMapping("/{recordId}")
    public ResponseEntity<BorrowingRecord> getBorrowingRecordById(@PathVariable Long recordId) {
        BorrowingRecord borrowingRecord = borrowingRecordService.getBorrowingRecordById(recordId);

        if (borrowingRecord != null) {
            return new ResponseEntity<>(borrowingRecord, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<BorrowingRecord> borrowBook(@RequestBody BorrowingRecord borrowingRecord) {
        BorrowingRecord addedRecord = borrowingRecordService.borrowBook(borrowingRecord);
        return new ResponseEntity<>(addedRecord, HttpStatus.CREATED);
    }

    @PutMapping("/{recordId}")
    public ResponseEntity<BorrowingRecord> returnBook(@PathVariable Long recordId) {
        BorrowingRecord returnedRecord = borrowingRecordService.returnBook(recordId);

        if (returnedRecord != null) {
            return new ResponseEntity<>(returnedRecord, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
