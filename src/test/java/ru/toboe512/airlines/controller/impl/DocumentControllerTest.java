package ru.toboe512.airlines.controller.impl;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import ru.toboe512.airlines.BaseIntegrationTest;
import ru.toboe512.airlines.util.ResourceUtil;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;
import static ru.toboe512.airlines.util.ResourceUtil.getResourceAsString;

@DisplayName("DocumentController integration tests")
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DocumentControllerTest extends BaseIntegrationTest {

    @Value("classpath:/api/document/response/get-all-documents.json")
    private Resource getAllDocumentsExpectedResponse;

    @Value("classpath:/api/document/response/get-document-by-id.json")
    private Resource getDocumentByIdExpectedResponse;

    @Value("classpath:/api/document/request/create-document.json")
    private Resource createDocumentExpectedRequest;

    @Value("classpath:/api/document/request/update-document.json")
    private Resource updateDocumentExpectedRequest;

    @Value("classpath:/api/auth/auth.json")
    private Resource authenticationRequest;

    private final static String BASE_URL = "/v1/documents";
    private final static int TEST_DOCUMENT_ID_1 = 1;
    private final static int TEST_DOCUMENT_ID_2 = 2;

    private final static String AUTH_URL = "/v1/authenticate";
    private static String accessToken;

    @Test
    @Order(0)
    @DisplayName("Get keycloak auth token")
    void getAuthToken() {

        String response = webTestClient
                .post()
                .uri(AUTH_URL)
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromValue(ResourceUtil.getResourceAsString(authenticationRequest)))
                .exchange()
                .expectBody(String.class)
                .returnResult()
                .getResponseBody();

        DocumentContext jsonContext = JsonPath.parse(response);
        accessToken = jsonContext.read("$['access_token']");
    }

    @Test
    @Order(1)
    @DisplayName("Get all documents")
    void getAllTest() {
        getTest(BASE_URL, getAllDocumentsExpectedResponse, 200, accessToken);
    }

    @Test
    @Order(2)
    @DisplayName("Get document by id")
    void getByIdTest() {
        getTest(BASE_URL + "/" + TEST_DOCUMENT_ID_1, getDocumentByIdExpectedResponse, 200, accessToken);
    }

    @Test
    @Order(3)
    @DisplayName("Create document")
    void createTest() {
        postTest(BASE_URL, createDocumentExpectedRequest, null, 201, accessToken);
    }

    @Test
    @Order(4)
    @DisplayName("Update document")
    void updateTest() {
        putTest(BASE_URL, updateDocumentExpectedRequest, null,200, accessToken);
    }

    @Test
    @Order(5)
    @DisplayName("Delete document by id")
    void deleteTest() {
        deleteTest(BASE_URL + "/" + TEST_DOCUMENT_ID_2, null, 204, accessToken);
    }
}
