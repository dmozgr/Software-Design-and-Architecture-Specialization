package com.example.sharingapp;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class ContactListController {
    private ContactList contactList;

    public ContactListController(ContactList contactList)
    {
        this.contactList = contactList;
    }
    public void setContacts(ArrayList<Contact> contact_list) {
        contactList.setContacts(contact_list);
    }

    public ArrayList<Contact> getContacts() {
        return contactList.getContacts();
    }

    public ArrayList<String> getAllUsernames(){
        return contactList.getAllUsernames();
    }

    public boolean addContact(Contact contact,Context context) {
        AddContactCommand addContactCommand = new AddContactCommand(contactList,contact,context);
        addContactCommand.execute();
        return addContactCommand.isExecuted();
    }

    public boolean deleteContact(Contact contact,Context context) {
        DeleteContactCommand deleteContactCommand = new DeleteContactCommand(contactList,contact,context);
        deleteContactCommand.execute();
        return deleteContactCommand.isExecuted();
    }

    public Contact getContact(int index) {
        return contactList.getContact(index);
    }

    public int getSize() {
        return contactList.getSize();
    }

    public Contact getUserByUsername(String username){
        return contactList.getUserByUsername(username);
    }

    public boolean hasContact(Contact contact) {
        return contactList.hasContact(contact);
    }

    public int getIndex(Contact contact) {
       return contactList.getIndex(contact);
    }

    public boolean isUsernameAvailable(String username){
        return contactList.isUsernameAvailable(username);
    }
    public boolean editContact(Contact contact, Contact updated_contact, Context context){
        EditContactCommand edit_contact_command = new EditContactCommand(contactList, contact, updated_contact, context);
        edit_contact_command.execute();
        return edit_contact_command.isExecuted();
    }

    public void loadContacts(Context context) {
        contactList.loadContacts(context);
    }

    /**
     * @param context
     * @return true: if save is successful, false: if save is unsuccessful
     */
    public boolean saveContacts(Context context) {
        return contactList.saveContacts(context);
    }

    public Contact getContactByUsername(String username)
    {
       return contactList.getContactByUsername(username);
    }

    public void addObserver(Observer observer) {
        contactList.addObserver(observer);
    }

    public void removeObserver(Observer observer) {
        contactList.removeObserver(observer);
    }
}
