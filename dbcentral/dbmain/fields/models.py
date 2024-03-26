from django.db import models

class Users(models.Model):
    username = models.CharField(max_length=100)
    email = models.EmailField()
    password = models.CharField(max_length=200)
    phone = models.CharField(max_length=15)
    dob = models.DateField(blank=False, null=False)
