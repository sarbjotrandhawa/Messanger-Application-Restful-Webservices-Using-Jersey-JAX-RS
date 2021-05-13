package org.sarb.java.messanger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.sarb.java.messanger.database.DatabaseClass;
import org.sarb.java.messanger.model.Profile;

public class ProfileService {

	private Map<String, Profile> profiles = DatabaseClass.getProfiles();

	public ProfileService() {
		profiles.put("Sarbjot", new Profile(1l, "Sarbjot", "Singh", "Sabjot"));
		profiles.put("Randhawa", new Profile(2l, "Randhawa", "Singh", "Randhawa"));
	}

	public List<Profile> getAllProfiles() {
		return new ArrayList<Profile>(profiles.values());
	}

	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}

	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}

	public Profile updateProfile(Profile profile) {
		if (profile.getProfileName().isEmpty()) {
			return null;
		} else {
			profiles.put(profile.getProfileName(), profile);
			return profile;
		}
	}

	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}

}
