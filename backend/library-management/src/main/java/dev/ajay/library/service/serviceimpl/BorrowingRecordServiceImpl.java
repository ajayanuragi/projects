package dev.ajay.library.service.serviceimpl;

import dev.ajay.library.model.BorrowingRecord;
import dev.ajay.library.repository.BorrowingRecordRepository;
import dev.ajay.library.service.BorrowingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowingRecordServiceImpl implements BorrowingRecordService {
    @Autowired
    private BorrowingRecordRepository borrowingRecordRepository;

    @Override
    public List<BorrowingRecord> getBorrowingRecordsByUsername(String username) {
        return borrowingRecordRepository.findByUser_Username(username);
    }

    @Override
    public BorrowingRecord getBorrowingRecordById(Long recordId) {
        return borrowingRecordRepository.findById(recordId).orElse(null);
    }

    @Override
    public BorrowingRecord borrowBook(BorrowingRecord borrowingRecord) {
        return borrowingRecordRepository.save(borrowingRecord);
    }

    @Override
    public BorrowingRecord returnBook(Long recordId) {
        BorrowingRecord existingRecord = getBorrowingRecordById(recordId);
        if (existingRecord != null) {
            return borrowingRecordRepository.save(existingRecord);
        } else {
            return null;
        }
    }
}
