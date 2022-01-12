#!/bin/bash
#
#     This file is part of NetGuard.
#     NetGuard is free software: you can redistribute it and/or modify
#     it under the terms of the GNU General Public License as published by
#     the Free Software Foundation, either version 3 of the License, or
#     (at your option) any later version.
#     NetGuard is distributed in the hope that it will be useful,
#     but WITHOUT ANY WARRANTY; without even the implied warranty of
#     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#     GNU General Public License for more details.
#     You should have received a copy of the GNU General Public License
#     along with NetGuard.  If not, see <http://www.gnu.org/licenses/>.
#     Copyright 2015-2019 by Marcel Bokhorst (M66B)
#

. tools/config.sh

#https://github.com/mendhak/Crowdin-Android-Importer
#git clone https://github.com/mendhak/Crowdin-Android-Importer.git
#sudo apt-get install python python-pip
#sudo apt-get install libssl-dev libcurl4-openssl-dev
#pip install pycurl

rm -R ${project_dir}/app/src/main/res/values-iw/
rm -R ${project_dir}/app/src/main/res/values-ar-rBH/
rm -R ${project_dir}/app/src/main/res/values-ar-rEG/
rm -R ${project_dir}/app/src/main/res/values-ar-rSA/
rm -R ${project_dir}/app/src/main/res/values-ar-rYE/
rm -R ${project_dir}/app/src/main/res/values-fi*
rm -R ${project_dir}/app/src/main/res/values-nb/

python ${importer_dir}/crowdin.py --p=app/src/main -a=get -i netguard -k ${api_key}

mkdir -p ${project_dir}/app/src/main/res/values-iw/
mkdir -p ${project_dir}/app/src/main/res/values-ar-rBH/
mkdir -p ${project_dir}/app/src/main/res/values-ar-rEG/
mkdir -p ${project_dir}/app/src/main/res/values-ar-rSA/
mkdir -p ${project_dir}/app/src/main/res/values-ar-rYE/
mkdir -p ${project_dir}/app/src/main/res/values-nb/

cp -R ${project_dir}/app/src/main/res/values-he/* ${project_dir}/app/src/main/res/values-iw/
cp -R ${project_dir}/app/src/main/res/values-ar/* ${project_dir}/app/src/main/res/values-ar-rBH/
cp -R ${project_dir}/app/src/main/res/values-ar/* ${project_dir}/app/src/main/res/values-ar-rEG/
cp -R ${project_dir}/app/src/main/res/values-ar/* ${project_dir}/app/src/main/res/values-ar-rSA/
cp -R ${project_dir}/app/src/main/res/values-ar/* ${project_dir}/app/src/main/res/values-ar-rYE/
cp -R ${project_dir}/app/src/main/res/values-no/* ${project_dir}/app/src/main/res/values-nb/

sed -i s/-2016/–2020/ ${project_dir}/app/src/main/res/values*/strings.xml
sed -i s/–2016/–2020/ ${project_dir}/app/src/main/res/values*/strings.xml
sed -i s/-2017/–2020/ ${project_dir}/app/src/main/res/values*/strings.xml
sed -i s/–2017/–2020/ ${project_dir}/app/src/main/res/values*/strings.xml
sed -i s/-2018/–2020/ ${project_dir}/app/src/main/res/values*/strings.xml
sed -i s/–2018/–2020/ ${project_dir}/app/src/main/res/values*/strings.xml
sed -i s/-2019/–2020/ ${project_dir}/app/src/main/res/values*/strings.xml
sed -i s/–2019/–2020/ ${project_dir}/app/src/main/res/values*/strings.xml
