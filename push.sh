#!/bin/sh
git remote add cleverapps
https://$CLEVER_TOKEN:$CLEVER_SECRET@push.clever-cloud.com/app_44cf8cc7-0858-4dc9-8d91-9af637cb64c6.git
git --verbose --force push cleverapps master