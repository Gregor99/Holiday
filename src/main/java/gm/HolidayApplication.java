package gm;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HolidayApplication extends Application<HolidayConfiguration> {

    public static void main(final String[] args) throws Exception {
        new HolidayApplication().run(args);
    }

    @Override
    public String getName() {
        return "Holiday";
    }

    @Override
    public void initialize(final Bootstrap<HolidayConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final HolidayConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
