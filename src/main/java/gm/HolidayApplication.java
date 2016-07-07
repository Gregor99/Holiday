package gm;

import gm.api.Holiday;
import gm.api.HolidayDAO;
import gm.resources.HolidayResource;
import gm.resources.IndexResource;
import io.dropwizard.Application;
import io.dropwizard.db.PooledDataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class HolidayApplication extends Application<HolidayConfiguration> {

    private final HibernateBundle<HolidayConfiguration> hibernateBundle =
            new HibernateBundle<HolidayConfiguration>(Holiday.class) {

                @Override
                public PooledDataSourceFactory getDataSourceFactory(HolidayConfiguration holidayConfiguration) {
                    return holidayConfiguration.getDataSourceFactory();
                }
            };

    public static void main(final String[] args) throws Exception {
        new HolidayApplication().run(args);
    }

    @Override
    public String getName() {
        return "Holiday";
    }

    @Override
    public void initialize(final Bootstrap<HolidayConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
    }

    @Override
    public void run(final HolidayConfiguration configuration,
                    final Environment environment) {
        final HolidayDAO holidayDAO = new HolidayDAO(hibernateBundle.getSessionFactory());

        environment.jersey().register(new IndexResource());
        environment.jersey().register(new HolidayResource(holidayDAO));
    }

}
