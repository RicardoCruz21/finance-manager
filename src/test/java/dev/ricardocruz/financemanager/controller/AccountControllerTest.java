package dev.ricardocruz.financemanager.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import dev.ricardocruz.financemanager.dto.AccountCreationRequest;
import dev.ricardocruz.financemanager.entity.Account;
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
    public void testCreateNewAccountSuccess() throws Exception {

        AccountCreationRequest request = new AccountCreationRequest();
        request.setAccountName("Bills");
        request.setAccountBalance(new BigDecimal("1945.67"));

        Account billsAccount = new Account(1L, "Bills", new BigDecimal("1945.67"));

        doReturn(billsAccount).when(accountService).createAccount(Mockito.any(AccountCreationRequest.class));

        ResultActions response = mockMvc.perform(post("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)));

        response.andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(billsAccount.getId())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountName", CoreMatchers.is(billsAccount.getAccountName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.accountBalance", CoreMatchers.is(billsAccount.getAccountBalance())));
    }

    @Test
    public void testCreateNewAccountFailure() throws Exception {
        AccountCreationRequest request = new AccountCreationRequest();
        request.setAccountName("Bills");
        request.setAccountBalance(new BigDecimal("1945.67"));

        Account mockAccount = new Account(1L, request.getAccountName(), request.getAccountBalance());

        doReturn(null).when(accountService).createAccount(Mockito.any(AccountCreationRequest.class));

        ResultActions response = mockMvc.perform(post("/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(request)));

        response.andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}
