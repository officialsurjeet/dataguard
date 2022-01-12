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

grep -RIl "\<string name=\"app_copyright" app/src/main/res | xargs sed -i -e 's/-2017/–2018/g'
grep -RIl "\<string name=\"app_copyright" app/src/main/res | xargs sed -i -e 's/–2017/–2018/g'


#grep -RIl "\<string name=\"setting_import" app/src/main/res | xargs sed -i -e '/setting_import/a\
#\ \ <string name="setting_backup">Backup</string>'
#grep -RIl "\<string name=\"setting_import" app/src/main/res | xargs sed -i -e '/setting_import/a\
#\ \ <string name="setting_options">Options</string>'
#grep -RIl "\<string name=\"setting_import" app/src/main/res | xargs sed -i -e '/setting_import/a\
#\ \ <string name="setting_defaults">Defaults</string>'

#grep -RIl "\<string name=\"summary_national_roaming" app/src/main/res | xargs sed -i -e '/summary_national_roaming/d'
#grep -RIl "\<string name=\"summary_metered" app/src/main/res | xargs sed -i -e '/summary_metered/a\
#\ \ <string name="summary_national_roaming">Do not apply the roaming rules when the SIM and mobile network country are the same</string>'

#grep -RIl "\<string name=\"setting_screen_wifi" app/src/main/res | xargs sed -i -e 's/xxx/yyy/g'
