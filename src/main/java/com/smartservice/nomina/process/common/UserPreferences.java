package com.smartservice.nomina.process.common;

import com.smartservice.nomina.process.model.Preference;
import com.smartservice.nomina.process.repository.PreferenceRepository;
import com.smartservice.nomina.process.util.UserPreference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.EnumMap;
import java.util.List;

@Component
public class UserPreferences {

    @Autowired
    private PreferenceRepository preferenceRepository;

    private EnumMap<UserPreference,String> preferences;

    @PostConstruct
    private void fillPreferences(){
        preferences = new EnumMap<>(UserPreference.class);
        List<Preference> lstPreferences = preferenceRepository.findAll();
        lstPreferences.forEach(preference -> {
            preferences.put(getKey(preference.getDescription()),preference.getValue());
        });
    }

    private UserPreference getKey(String description) {
        return UserPreference.valueOf(description);
    }


    public String getUserPreference(UserPreference userPreference){
        return preferences.get(userPreference);
    }
}
