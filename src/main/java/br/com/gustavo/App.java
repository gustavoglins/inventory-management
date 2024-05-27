package br.com.gustavo;

import br.com.gustavo.service.ApplicationService;

public class App {

    private static final ApplicationService applicationService = new ApplicationService();

    public static void main(String[] args) {

        applicationService.brand();
        applicationService.menu();
    }
}
