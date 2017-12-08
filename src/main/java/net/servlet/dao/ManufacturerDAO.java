package net.servlet.dao;

import net.servlet.model.Manufacturer;

import java.util.UUID;

public interface ManufacturerDAO extends GenericDAO<Manufacturer, UUID> {
    Manufacturer getByName(String name);
}
