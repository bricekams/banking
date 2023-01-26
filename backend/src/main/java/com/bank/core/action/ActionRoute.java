package com.bank.core.action;

import com.bank.core.account.AccountRepository;
import com.bank.core.action.utils.NewActionRecord;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/actions")
public class ActionRoute {
    private final ActionRepository actionRepository;
    private final AccountRepository accountRepository;

    public ActionRoute(ActionRepository actionRepository, AccountRepository accountRepository) {
        this.actionRepository = actionRepository;
        this.accountRepository = accountRepository;
    }

    @GetMapping
    public List<Action> getActions(
            @RequestParam( name = "eventfulAccount",required = false) String eventfulAccount,
            @RequestParam(name = "amount",required = false) Float amount,
            @RequestParam(name = "amountGreaterThan",required = false) Float amountGreaterThan,
            @RequestParam(name = "amountLessThan",required = false) Float amountLessThan,
            @RequestParam(name = "actionType",required = false) String actionType,
            HttpServletRequest httpServletRequest
            ){
        return new ActionController(actionRepository, accountRepository).getActions(eventfulAccount,amount,amountGreaterThan,amountLessThan,actionType,httpServletRequest);
    }

    @PostMapping
    public void createAction(@RequestBody NewActionRecord newActionRecord){
        new ActionController(actionRepository,accountRepository).createAction(newActionRecord);
    }

    @GetMapping("{actionId}")
    public Action getAction(@PathVariable("actionId")Long actionId){
        return actionRepository.findById(actionId).orElse(null);
    }
}
