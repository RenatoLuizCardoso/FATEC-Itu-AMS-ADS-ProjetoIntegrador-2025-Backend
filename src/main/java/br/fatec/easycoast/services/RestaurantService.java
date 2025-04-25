package br.fatec.easycoast.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.easycoast.dtos.restaurant.RestaurantRequest;
import br.fatec.easycoast.dtos.restaurant.RestaurantResponse;
import br.fatec.easycoast.entities.Restaurant;
import br.fatec.easycoast.mappers.RestaurantMapper;
import br.fatec.easycoast.repositories.RestaurantRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class RestaurantService {
    @Autowired
    RestaurantRepository restaurantRepository;

    public RestaurantResponse getRestaurant() { // There will be only one restaurant in the DB
        // After catching the restaurant, turn it to a DTO
        return RestaurantMapper.toDto(restaurantRepository.findById(1) // find by 1, because there is only one
                .orElseThrow(() -> new EntityNotFoundException())); // Needed because the function need
    }

    public RestaurantResponse saveRestaurant(RestaurantRequest request) {
        // Saving the restaurant withou an id, because the id will be added auto
        if (getRestaurant() != null) {
            throw new EntityExistsException("Restaurant is created already!");
        } else {
            Restaurant restaurant = restaurantRepository.save(RestaurantMapper.toEntity(request));
            return RestaurantMapper.toDto(restaurant);
        }
    }

    public void updateRestaurant(int id, RestaurantRequest request) {
        Restaurant restaurant = restaurantRepository.getReferenceById(id);

        restaurant.setName(request.name());
        restaurant.setLocation(request.location());
        restaurant.setWhoAreWe(request.whoAreWe());

        restaurantRepository.save(restaurant);
    }
}
