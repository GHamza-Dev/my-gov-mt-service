package io.flat.mtservice.transaction;

import io.flat.mtservice.services.MEFRestClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private TransactionRepository transactionRepository;
    private MEFRestClient mefRestClient;

    public TransactionService(TransactionRepository transactionRepository,
                              MEFRestClient mefRestClient) {
        this.transactionRepository = transactionRepository;
        this.mefRestClient = mefRestClient;
    }

    public boolean createTransaction(TransactionDto transactionDto){
        Transaction transaction = new Transaction();

        transaction.setName(transactionDto.name);
        transaction.setDescription(transactionDto.description);

        transactionRepository.save(transaction);

        try {
            transactionDto.ministryUUID = "2ec54edf-7620-4e41-a401-28b80618cd3d";
            mefRestClient.create(transactionDto);
        }catch (Exception e){
            System.out.println(e);
        }finally {
            return transaction.getId() != null;
        }
    }

    public Transaction getTransactionById(Long id){
        return transactionRepository.findById(id).orElseGet(null);
    }

    public List<Transaction> getAllTransactions(){
        return transactionRepository.findAll();
    }
}
