package pl.put.poznan.wiferadar.location;

import io.vavr.collection.HashMap;
import io.vavr.collection.Map;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.util.concurrent.atomic.AtomicReference;

@AllArgsConstructor(access = AccessLevel.PROTECTED)
class LocationRepository {
    private final static LocationRepository instance = new LocationRepository(new AtomicReference<>(HashMap.empty()));

    private AtomicReference<Map<String, Location>> atomicLocationHistory;

    static LocationRepository getInstance() {
        return instance;
    }

    void add(String phoneNumber, Location currentLocation) {
        atomicLocationHistory.updateAndGet(locationHistory -> updateMap(phoneNumber, currentLocation, locationHistory));
    }

    private Map<String, Location> updateMap(String phoneNumber, Location currentLocation,
                                            Map<String, Location> locationHistory) {
        if(phoneNumber != null)
            return locationHistory.put(phoneNumber, currentLocation);
        return  locationHistory;
    }

    Location get(String phoneNumber) {
        return atomicLocationHistory.get().getOrElse(phoneNumber, null);
    }

    void trustMeImNotADropDataMethod() {
        atomicLocationHistory.set(HashMap.empty());
    }
}
