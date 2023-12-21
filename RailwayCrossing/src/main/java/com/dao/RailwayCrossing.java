package com.dao;

import java.util.List;

import com.RailwayCrossing1;

public interface RailwayCrossing {

	public List<RailwayCrossing1> getAllCrossings();

	public RailwayCrossing1 getCrossingById(int crossingId);

	public void updateCrossing(RailwayCrossing1 crossing);

	public void deleteCrossing(int crossingId);

	public void addCrossing(RailwayCrossing1 crossing);

	public List<RailwayCrossing1> getFavoriteCrossings();

	public void addToFavorites(int crossingId);

	public void removeFromFavorites(int crossingId);

}
