package controller;

import data.ComplexNumber;
import data.ComplexOperation;
import view.CalculatorView;

import java.util.logging.*;

public class CalculatorPresenter {
    private static final Logger logger = Logger.getLogger(CalculatorPresenter.class.getName());
    private final CalculatorView view;

    public CalculatorPresenter(CalculatorView view) {
        this.view = view;

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setFormatter(new SimpleFormatter());
        logger.addHandler(consoleHandler);
        logger.setUseParentHandlers(false);
    }

    public void performOperation(ComplexNumber a, ComplexNumber b, ComplexOperation operation) {
        logger.log(Level.INFO, "Performing {0} with numbers: ({1}) and ({2})", new Object[]{operation.getName(), a, b});
        //let's flush logger buffer, because it shows everything before the results in console:
        /* !!!DIDN'T WORK!!! */
        for (Handler handler : LogManager.getLogManager().getLogger("").getHandlers()) {
            if (handler instanceof ConsoleHandler) {
                handler.flush();
            }
        }
        try {
            ComplexNumber result = operation.execute(a, b);
            view.displayResult(result.toString());
        } catch (Exception e) {
            logger.log(Level.SEVERE, "An error occurred during the operation", e);
            //let's try flushing everything in case of an error:
            /* !!!DIDN'T WORK!!! */
            System.out.flush();
            view.showError(e.getMessage());
        }
    }
}
