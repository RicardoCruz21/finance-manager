package dev.ricardocruz.financemanager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.ricardocruz.financemanager.constants.AccountConstants;
import dev.ricardocruz.financemanager.dto.AccountDto;
import dev.ricardocruz.financemanager.model.AccountResponse;
import dev.ricardocruz.financemanager.service.AccountService;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@WebMvcTest(AccountController.class)
public class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testCreateAccountSuccess() throws Exception {

        AccountDto accountDto = new AccountDto();
        accountDto.setAccountName("Bills");
        accountDto.setAccountBalance(new BigDecimal("1945.67"));

        AccountDto billsAccountDto = new AccountDto();
        billsAccountDto.setId(1L);
        billsAccountDto.setAccountName("Bills");
        billsAccountDto.setAccountBalance(new BigDecimal("1945.67"));
        AccountResponse accountResponse = new AccountResponse(true, AccountConstants.SUCCESS_ACCOUNT_CREATED, billsAccountDto);

        doReturn(accountResponse).when(accountService).createAccount(Mockito.any(AccountDto.class));

        ResultActions response = mockMvc.perform(post("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(accountDto)));

        response.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.account.id").value(accountResponse.getAccount().getId()))
                .andExpect(MockMvcResultMatchers.jsonPath("$.account.accountName", CoreMatchers.is(accountResponse.getAccount().getAccountName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.account.accountBalance").value(accountResponse.getAccount().getAccountBalance()));
    }
}
