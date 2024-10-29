package lexicon.se.market_api.exception;



public class AdvertisementException extends RuntimeException {

    public AdvertisementException(String message) {
        super(message);
    }

    public AdvertisementException(String message, Throwable cause) {
        super(message, cause);
    }
}
