package tests;

import com.bankofusa.api.ApiRequest;
import com.bankofusa.api.asserts.ApiAssert;
import com.bankofusa.api.controller.PlayerController;
import com.bankofusa.api.models.apiBody.authentication.AuthenticationResponseBody;
import com.bankofusa.api.models.apiBody.players.GetPlayerResponseBody;
import com.bankofusa.api.models.apiBody.players.PlayersRequestBody;
import com.bankofusa.api.models.apiBody.players.PlayersResponseBody;
import com.bankofusa.api.utils.EntityManager;
import org.testng.annotations.BeforeClass;

import java.util.ArrayList;
import java.util.List;

import static com.bankofusa.api.application.BaseEndPoints.BASE_URL;

public class BaseApiTest {
    PlayerController playerController;
    PlayersRequestBody playersRequestBody;
    GetPlayerResponseBody getPlayerResponseBody;
    List<PlayersResponseBody> playersResponseBodies;
    AuthenticationResponseBody authenticationResponseBody;
    ApiRequest apiRequest;

    ApiAssert apiAssert;

    @BeforeClass(alwaysRun = true)
    public void beforeClass() {
        playerController = new PlayerController(BASE_URL);
        playersRequestBody = EntityManager.generatePlayerRequest();
        playersResponseBodies = new ArrayList<>();
        apiRequest = new ApiRequest(BASE_URL);


    }
}