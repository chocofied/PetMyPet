package com.example.csun24.petmypet;

interface GetUserCallback {

    /**
     * Invoked when background task is completed
     */

    public abstract void done(User returnedUser);
}