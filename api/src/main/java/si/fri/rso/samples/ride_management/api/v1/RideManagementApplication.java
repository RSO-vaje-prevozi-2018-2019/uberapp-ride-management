package si.fri.rso.samples.ride_management.api.v1;

import com.kumuluz.ee.discovery.annotations.RegisterService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@RegisterService("uberapp-ride-management")
@ApplicationPath("/v1")
public class RideManagementApplication extends Application {
}
