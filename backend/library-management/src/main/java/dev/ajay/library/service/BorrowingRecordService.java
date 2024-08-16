package dev.ajay.library.service;

import dev.ajay.library.model.BorrowingRecord;

import java.util.List;

public interface BorrowingRecordService {
    List<BorrowingRecord> getBorrowingRecordsByUsername(String username);

    BorrowingRecord getBorrowingRecordById(Long recordId);

    BorrowingRecord borrowBook(BorrowingRecord borrowingRecord);

    BorrowingRecord returnBook(Long recordId);
}
