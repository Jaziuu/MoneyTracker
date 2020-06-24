package pl.jaziuu.walletservice;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import pl.jaziuu.walletservice.model.Expense;
import pl.jaziuu.walletservice.model.Income;
import pl.jaziuu.walletservice.model.Wallet;
import pl.jaziuu.walletservice.repository.ExpenseRepository;
import pl.jaziuu.walletservice.repository.IncomeRepository;
import pl.jaziuu.walletservice.repository.WalletRepository;

@Service
public class DbInit implements CommandLineRunner {


   private WalletRepository walletRepository;
   private IncomeRepository incomeRepository;
   private ExpenseRepository expenseRepository;

    public DbInit(WalletRepository walletRepository, IncomeRepository incomeRepository, ExpenseRepository expenseRepository) {
        this.walletRepository = walletRepository;
        this.incomeRepository = incomeRepository;
        this.expenseRepository = expenseRepository;
    }


    @Override
    public void run(String... args) throws Exception {


        Wallet wallet = new Wallet("Admin wallet",1L);
        Income income = new Income();
        income.setWalletId(wallet.getId());
        income.setAmount(222);
        income.setDescription("Test");
        income.setTitle("Title test");
        incomeRepository.save(income);
        var walletIncomes = wallet.getIncomes();
        walletIncomes.add(income);
        wallet.setIncomes(walletIncomes);

        Expense expense = new Expense();
        expense.setWalletId(wallet.getId());
        expense.setAmount(2323);
        expense.setDescription("TestExpense");
        expense.setTitle("ExTestTitle");
        expenseRepository.save(expense);

        var walletExpenses = wallet.getExpenses();
        walletExpenses.add(expense);
        wallet.setExpenses(walletExpenses);

        walletRepository.save(wallet);

//
//
//        roleRepository.save(new Role(RoleName.ROLE_USER));
//        roleRepository.save(new Role(RoleName.ROLE_ADMIN));
//
//        User admin = new User("admin",encoder.encode("admin123"),"adminemail@gmail.com");
//        User user = new User("user",encoder.encode("user123"),"useremail@gmail.com");
//        Todo todo1 = new Todo("Finish this app",admin);
//        Todo todo2 = new Todo("Create UI",admin);
//        Todo todo3 = new Todo("Make coffe",user);
//        Todo todo4 = new Todo("Find Job",user);
//
//        userRepository.save(admin);
//        userRepository.save(user);
//
//        todoRepository.save(todo1);
//        todoRepository.save(todo2);
//        todoRepository.save(todo3);
//        todoRepository.save(todo4);
//
//        Set<Todo> adminTodos= new HashSet<>();
//        adminTodos.add(todo1);
//        adminTodos.add(todo2);
//        admin.setTodos(adminTodos);
//
//        Set<Todo> userTodos= new HashSet<>();
//        userTodos.add(todo3);
//        userTodos.add(todo4);
//        user.setTodos(userTodos);
//
//        Set<Role> adminRoles = new HashSet<>();
//        Set<Role> userRoles = new HashSet<>();
//
//        Role adminRole = roleRepository.findByName(RoleName.ROLE_ADMIN)
//                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
//
//        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
//                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
//
//        adminRoles.add(userRole);
//        adminRoles.add(adminRole);
//        userRoles.add(userRole);
//
//        admin.setRoles(adminRoles);
//        userRepository.save(admin);
//
//        user.setRoles(userRoles);
//        userRepository.save(user);

    }
}
